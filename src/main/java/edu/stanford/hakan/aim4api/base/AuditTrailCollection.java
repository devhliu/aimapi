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
public class AuditTrailCollection implements IAimXMLOperations {

    private List<AuditTrail> listAuditTrail = new ArrayList<AuditTrail>();

    public void addAuditTrail(AuditTrail newAuditTrail) {
        this.listAuditTrail.add(newAuditTrail);
    }

    public List<AuditTrail> getAuditTrailList() {
        return this.listAuditTrail;
    }

    public int size() {
        return this.listAuditTrail.size();
    }

    public AuditTrail get(int index) {
        if (index <= this.listAuditTrail.size() - 1) {
            return this.listAuditTrail.get(index);
        }
        return null;
    }

    @Override
    public Node getXMLNode(Document doc) throws AimException {

        Element auditTrailCollection = doc.createElement("auditTrailCollection");
        for (int i = 0; i < this.listAuditTrail.size(); i++) {
            this.listAuditTrail.get(i).setTagName("AuditTrail");
            auditTrailCollection.appendChild(this.listAuditTrail.get(i).getXMLNode(doc));
        }
        return auditTrailCollection;
    }

    @Override
    public void setXMLNode(Node node) {
        this.listAuditTrail.clear();
        NodeList tempList = node.getChildNodes();
        for (int j = 0; j < tempList.getLength(); j++) {
            Node currentNode = tempList.item(j);
            if ("AuditTrail".equals(currentNode.getNodeName())) {
                NamedNodeMap map = currentNode.getAttributes();
                if (map.getNamedItem("xsi:type") != null) {
                    String xsiType = map.getNamedItem("xsi:type").getNodeValue();
                } else {
                    AuditTrail obj = new AuditTrail();
                    obj.setXMLNode(tempList.item(j));
                    this.addAuditTrail(obj);
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
        AuditTrailCollection oth = (AuditTrailCollection) other;
        if (this.listAuditTrail.size() != oth.listAuditTrail.size()) {
            return false;
        }
        for (int i = 0; i < this.listAuditTrail.size(); i++) {
            if (this.listAuditTrail.get(i) == null ? oth.listAuditTrail.get(i) != null : !this.listAuditTrail.get(i).isEqualTo(oth.listAuditTrail.get(i))) {
                return false;
            }
        }
        return true;
    }

    public AuditTrailCollection getClone() {
        AuditTrailCollection res = new AuditTrailCollection();
        for (int i = 0; i < this.listAuditTrail.size(); i++) {
            if (this.listAuditTrail.get(i) != null) {
                res.addAuditTrail(this.listAuditTrail.get(i).getClone());
            }
        }
        return res;
    }
}
