/*
 * Copyright (c) 2011, The Board of Trustees of the Leland Stanford Junior 
 * University, creator Daniel L. Rubin. 
 * 
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 * 
 * Redistributions of source code must retain the above copyright notice, this 
 * list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
 * this list of conditions and the following disclaimer in the documentation 
 * and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 */
package edu.stanford.hakan.aim4api.compability.aimv3_old;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Hakan BULU
 */
public class CalculationData {

    private CoordinateCollection coordinateCollection = new CoordinateCollection();
    private Integer cagridId;
    private Double value;

    public CalculationData() {
    }

    public CalculationData(Integer cagridId, Double value) {
        this.cagridId = cagridId;
        this.value = value;
    }

    public Integer getCagridId() {
        return cagridId;
    }

    public void setCagridId(Integer cagridId) {
        this.cagridId = cagridId;
    }

    public CoordinateCollection getCoordinateCollection() {
        return coordinateCollection;
    }

    public void setCoordinateCollection(CoordinateCollection coordinateCollection) {
        this.coordinateCollection = coordinateCollection;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void addCoordinate(Integer cagridId, Integer dimensionIndex, Integer position) {
        Coordinate newCoordinate = new Coordinate(cagridId, dimensionIndex, position);
        this.coordinateCollection.AddCoordinate(newCoordinate);
    }

    public void setXMLNode(Node node) {

        NodeList listChils = node.getChildNodes();
        for (int i = 0; i < listChils.getLength(); i++) {
            if ("coordinateCollection".equals(listChils.item(i).getNodeName())) {
                this.coordinateCollection.setXMLNode(listChils.item(i));
            }
        }

        NamedNodeMap map = node.getAttributes();
        this.cagridId = Integer.parseInt(map.getNamedItem("cagridId").getNodeValue());
        this.value = Double.parseDouble(map.getNamedItem("value").getNodeValue());
    }

    public CalculationData(edu.stanford.hakan.aim4api.base.CalculationData v4) {
        this.setCagridId(0);
        if (v4.getCoordinateCollection().getCoordinateList().size() > 0) {
            this.setCoordinateCollection(new CoordinateCollection(v4.getCoordinateCollection()));
        }
        if (v4.getValue() != null) {
            this.setValue(Double.parseDouble(v4.getValue().getValue()));
        }
    }

    public edu.stanford.hakan.aim4api.base.CalculationData toAimV4() {
        edu.stanford.hakan.aim4api.base.CalculationData res = new edu.stanford.hakan.aim4api.base.CalculationData();
        res.setCoordinateCollection(this.getCoordinateCollection().toAimV4());
        res.setValue(Converter.toST(this.getValue()));
        return res;
    }
}