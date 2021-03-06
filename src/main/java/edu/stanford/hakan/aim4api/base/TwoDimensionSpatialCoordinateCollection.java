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
package edu.stanford.hakan.aim4api.base;

import edu.stanford.hakan.aim4api.utility.Logger;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author localadmin
 */
public class TwoDimensionSpatialCoordinateCollection implements IAimXMLOperations {

    private List<TwoDimensionSpatialCoordinate> listTwoDimensionSpatialCoordinate = new ArrayList<TwoDimensionSpatialCoordinate>();    
    private TwoDimensionGeometricShapeEntity twoDimensionGeometricShapeEntity;

    public void addTwoDimensionSpatialCoordinate(TwoDimensionSpatialCoordinate newTwoDimensionSpatialCoordinate) {
        this.listTwoDimensionSpatialCoordinate.add(newTwoDimensionSpatialCoordinate);
        newTwoDimensionSpatialCoordinate.setTwoDimensionSpatialCoordinateCollection(this);
        newTwoDimensionSpatialCoordinate.setTwoDimensionGeometricShapeEntity(twoDimensionGeometricShapeEntity);
    }

    public List<TwoDimensionSpatialCoordinate> getTwoDimensionSpatialCoordinateList() {
        return this.listTwoDimensionSpatialCoordinate;
    }

    public int size() {
        return this.listTwoDimensionSpatialCoordinate.size();
    }

    public TwoDimensionSpatialCoordinate get(int index) {
        if (index <= this.listTwoDimensionSpatialCoordinate.size() - 1) {
            return this.listTwoDimensionSpatialCoordinate.get(index);
        }
        return null;
    }

    public TwoDimensionGeometricShapeEntity getTwoDimensionGeometricShapeEntity() {
        return twoDimensionGeometricShapeEntity;
    }

    public void setTwoDimensionGeometricShapeEntity(TwoDimensionGeometricShapeEntity twoDimensionGeometricShapeEntity) {
        this.twoDimensionGeometricShapeEntity = twoDimensionGeometricShapeEntity;
    }   

    @Override
    public Node getXMLNode(Document doc) throws AimException {

        Element twoDimensionSpatialCoordinateCollection = doc.createElement("twoDimensionSpatialCoordinateCollection");
        for (int i = 0; i < this.listTwoDimensionSpatialCoordinate.size(); i++) {
            this.listTwoDimensionSpatialCoordinate.get(i).setTagName("TwoDimensionSpatialCoordinate");
            twoDimensionSpatialCoordinateCollection
                    .appendChild(this.listTwoDimensionSpatialCoordinate.get(i).getXMLNode(doc));
        }
        return twoDimensionSpatialCoordinateCollection;
    }

    @Override
    public void setXMLNode(Node node) {
        this.listTwoDimensionSpatialCoordinate.clear();
        NodeList tempList = node.getChildNodes();
        for (int j = 0; j < tempList.getLength(); j++) {
            Node currentNode = tempList.item(j);
            if ("TwoDimensionSpatialCoordinate".equals(currentNode.getNodeName())) {
                NamedNodeMap map = currentNode.getAttributes();
                if (map.getNamedItem("xsi:type") != null) {
                    String xsiType = map.getNamedItem("xsi:type").getNodeValue();

                } else {
                    TwoDimensionSpatialCoordinate obj = new TwoDimensionSpatialCoordinate();
                    obj.setXMLNode(tempList.item(j));
                    this.addTwoDimensionSpatialCoordinate(obj);
                }
            }
        }

    }

    @Override
    public Node getRDFNode(Document doc, String unquieID, String Prefix) throws AimException {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools
// | Templates.
    }

    @Override
    public boolean isEqualTo(Object other) {
        //Logger.write("Geldi TwoDimensionSpatialCoordinateCollection isEqualTo");
        TwoDimensionSpatialCoordinateCollection oth = (TwoDimensionSpatialCoordinateCollection) other;
        if (this.listTwoDimensionSpatialCoordinate.size() != oth.listTwoDimensionSpatialCoordinate.size()) {
            return false;
        }
        //Logger.write("this.listTwoDimensionSpatialCoordinate.size(): " + this.listTwoDimensionSpatialCoordinate.size());
        for (int i = 0; i < this.listTwoDimensionSpatialCoordinate.size(); i++) {
            if (this.listTwoDimensionSpatialCoordinate.get(i) == null ? oth.listTwoDimensionSpatialCoordinate.get(i) != null : !this.listTwoDimensionSpatialCoordinate.get(i).isEqualTo(oth.listTwoDimensionSpatialCoordinate.get(i))) {
                return false;
            }
        }
        //Logger.write("Geldi TwoDimensionSpatialCoordinateCollection returning true");
        return true;
    }

    public TwoDimensionSpatialCoordinateCollection getClone() {
        TwoDimensionSpatialCoordinateCollection res = new TwoDimensionSpatialCoordinateCollection();
        for (int i = 0; i < this.listTwoDimensionSpatialCoordinate.size(); i++) {
            if (this.listTwoDimensionSpatialCoordinate.get(i) != null) {
                res.addTwoDimensionSpatialCoordinate(this.listTwoDimensionSpatialCoordinate.get(i).getClone());
            }
        }
        return res;
    }
}
