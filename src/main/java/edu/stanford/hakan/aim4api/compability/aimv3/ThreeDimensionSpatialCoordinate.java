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
package edu.stanford.hakan.aim4api.compability.aimv3;

import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author Hakan BULU
 */
public class ThreeDimensionSpatialCoordinate extends SpatialCoordinate {

    private Double x;
    private Double y;
    private Double z;
    private String frameOfReferenceUID;

    public ThreeDimensionSpatialCoordinate() {
        setXsiType("ThreeDimensionSpatialCoordinate");
    }

    public ThreeDimensionSpatialCoordinate(Integer cagridId, Integer coordinateIndex, Double x, Double y, Double z, String frameOfReferenceUID) {

        setCagridId(cagridId);
        setCoordinateIndex(coordinateIndex);
        this.x = x;
        this.y = y;
        this.y = z;
        this.frameOfReferenceUID = frameOfReferenceUID;
        setXsiType("ThreeDimensionSpatialCoordinate");
    }

    public String getFrameOfReferenceUID() {
        return frameOfReferenceUID;
    }

    public void setFrameOfReferenceUID(String frameOfReferenceUID) {
        this.frameOfReferenceUID = frameOfReferenceUID;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    @Override
    public void setXMLNode(Node node) {
        super.setXMLNode(node);
        NamedNodeMap map = node.getAttributes();
        this.setFrameOfReferenceUID(map.getNamedItem("frameOfReferenceUID").getNodeValue());
        this.setX(Double.parseDouble(map.getNamedItem("x").getNodeValue()));
        this.setY(Double.parseDouble(map.getNamedItem("y").getNodeValue()));
        this.setZ(Double.parseDouble(map.getNamedItem("z").getNodeValue()));
    }
}
