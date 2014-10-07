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

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

/**
 *
 * @author Hakan BULU
 */
public class ReferencedAnnotation {

    private Integer cagridId;
    private String referencedAnnotationUID;
    private List<AnnotationRole> listAnnotationRole;

    public ReferencedAnnotation() {
        this.listAnnotationRole = new ArrayList<AnnotationRole>();
    }

    public ReferencedAnnotation(Integer cagridId, String referencedAnnotationUID) {
        this.cagridId = cagridId;
        this.referencedAnnotationUID = referencedAnnotationUID;
        this.listAnnotationRole = new ArrayList<AnnotationRole>();
    }

    public Integer getCagridId() {
        return cagridId;
    }

    public void setCagridId(Integer cagridId) {
        this.cagridId = cagridId;
    }

    public List<AnnotationRole> getListAnnotationRole() {
        return listAnnotationRole;
    }

    public void setListAnnotationRole(List<AnnotationRole> listAnnotationRole) {
        this.listAnnotationRole = listAnnotationRole;
    }

    public String getReferencedAnnotationUID() {
        return referencedAnnotationUID;
    }

    public void setReferencedAnnotationUID(String referencedAnnotationUID) {
        this.referencedAnnotationUID = referencedAnnotationUID;
    }

    public void addAnnotationRole(AnnotationRole newAnnotationRole) {
        this.listAnnotationRole.add(newAnnotationRole);
    }

    public void addAnnotationRole(Integer cagridId, String codeValue, String codeMeaning, String codingSchemeDesignator, String codingSchemeVersion, Integer roleSequenceNumber) {
        AnnotationRole newRole = new AnnotationRole(cagridId, codeValue, codeMeaning, codingSchemeDesignator, codingSchemeVersion, roleSequenceNumber);
        this.listAnnotationRole.add(newRole);
    }

    public void setXMLNode(Node node) {

        this.listAnnotationRole.clear();
        NodeList listChils = node.getChildNodes();
        for (int i = 0; i < listChils.getLength(); i++) {
            if ("annotationRole".equals(listChils.item(i).getNodeName())) {
                NodeList tempList = listChils.item(i).getChildNodes();
                for (int j = 0; j < tempList.getLength(); j++) {
                    if ("AnnotationRole".equals(tempList.item(j).getNodeName())) {
                        AnnotationRole obj = new AnnotationRole();
                        obj.setXMLNode(tempList.item(j));
                        this.addAnnotationRole(obj);
                    }
                }
            }
        }

        NamedNodeMap map = node.getAttributes();
        this.cagridId = Integer.parseInt(map.getNamedItem("cagridId").getNodeValue());
        this.referencedAnnotationUID = map.getNamedItem("referencedAnnotationUID").getNodeValue();
    }

}