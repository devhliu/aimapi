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

import edu.stanford.hakan.aim4api.base.Algorithm;
import edu.stanford.hakan.aim4api.base.CD;

import edu.stanford.hakan.aim4api.base.AnnotationStatement;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Hakan BULU
 */
public class Calculation {

    private Integer cagridId;
    private String uid;
    private String description;
    private String mathML;
    private String codeValue;
    private String codeMeaning;
    private String codingSchemeDesignator;
    private String codingSchemeVersion;
    private String algorithmName;
    private String algorithmVersion;
    private CalculationResultCollection calculationResultCollection = new CalculationResultCollection();
    private ReferencedCalculationCollection referencedCalculationCollection = new ReferencedCalculationCollection();
    private ReferencedGeometricShapeCollection referencedGeometricShapeCollection = new ReferencedGeometricShapeCollection();
    private String rdfID;
    private boolean codeValueCanBeNull;

    public Calculation() {
        this.codeValueCanBeNull = false;
    }

    public Calculation(Integer cagridId, String uid, String description, String mathML, String codeValue, String codeMeaning, String codingSchemeDesignator, String codingSchemeVersion, String algorithmName, String algorithmVersion) {
        this.cagridId = cagridId;
        this.uid = uid;
        this.description = description;
        this.mathML = mathML;
        this.codeValue = codeValue;
        this.codeMeaning = codeMeaning;
        this.codingSchemeDesignator = codingSchemeDesignator;
        this.codingSchemeVersion = codingSchemeVersion;
        this.algorithmName = algorithmName;
        this.algorithmVersion = algorithmVersion;
        this.codeValueCanBeNull = false;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public String getAlgorithmVersion() {
        return algorithmVersion;
    }

    public void setAlgorithmVersion(String algorithmVersion) {
        this.algorithmVersion = algorithmVersion;
    }

    public Integer getCagridId() {
        return cagridId;
    }

    public void setCagridId(Integer cagridId) {
        this.cagridId = cagridId;
    }

    public CalculationResultCollection getCalculationResultCollection() {
        return calculationResultCollection;
    }

    public void setCalculationResultCollection(CalculationResultCollection calculationResultCollection) {
        this.calculationResultCollection = calculationResultCollection;
    }

    public String getCodeMeaning() {
        return codeMeaning;
    }

    public void setCodeMeaning(String codeMeaning) {
        this.codeMeaning = codeMeaning;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getCodingSchemeDesignator() {
        return codingSchemeDesignator;
    }

    public void setCodingSchemeDesignator(String codingSchemeDesignator) {
        this.codingSchemeDesignator = codingSchemeDesignator;
    }

    public String getCodingSchemeVersion() {
        return codingSchemeVersion;
    }

    public void setCodingSchemeVersion(String codingSchemeVersion) {
        this.codingSchemeVersion = codingSchemeVersion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMathML() {
        return mathML;
    }

    public void setMathML(String mathML) {
        this.mathML = mathML;
    }

    public ReferencedCalculationCollection getReferencedCalculationCollection() {
        return referencedCalculationCollection;
    }

    public void setReferencedCalculationCollection(ReferencedCalculationCollection referencedCalculationCollection) {
        this.referencedCalculationCollection = referencedCalculationCollection;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public ReferencedGeometricShapeCollection getReferencedGeometricShapeCollection() {
        return referencedGeometricShapeCollection;
    }

    public void setReferencedGeometricShapeCollection(ReferencedGeometricShapeCollection referencedGeometricShapeCollection) {
        this.referencedGeometricShapeCollection = referencedGeometricShapeCollection;
    }

    public void addReferencedCalculation(ReferencedCalculation newReferencedCalculation) {
        this.referencedCalculationCollection.AddReferencedCalculation(newReferencedCalculation);
    }

    public void addCalculationResult(CalculationResult newCalculationResult) {
        this.calculationResultCollection.AddCalculationResult(newCalculationResult);
    }

    public void addReferencedGeometricShape(ReferencedGeometricShape newReferencedGeometricShape) {
        this.referencedGeometricShapeCollection.AddReferencedGeometricShape(newReferencedGeometricShape);
    }

    public String getRdfID() {
        return rdfID;
    }

    public void setRdfID(String rdfID) {
        this.rdfID = rdfID;
    }

    public boolean isCodeValueCanBeNull() {
        return codeValueCanBeNull;
    }

    public void setCodeValueCanBeNull(boolean codeValueCanBeNull) {
        this.codeValueCanBeNull = codeValueCanBeNull;
    }

    public void setXMLNode(Node node) {

        NodeList listChils = node.getChildNodes();
        for (int i = 0; i < listChils.getLength(); i++) {
            if ("referencedCalculationCollection".equals(listChils.item(i).getNodeName())) {
                this.referencedCalculationCollection.setXMLNode(listChils.item(i));
            } else if ("calculationResultCollection".equals(listChils.item(i).getNodeName())) {
                this.calculationResultCollection.setXMLNode(listChils.item(i));
            } else if ("referencedGeometricShapeCollection".equals(listChils.item(i).getNodeName())) {
                this.referencedGeometricShapeCollection.setXMLNode(listChils.item(i));
            }
        }

        NamedNodeMap map = node.getAttributes();
        this.cagridId = Integer.parseInt(map.getNamedItem("cagridId").getNodeValue());
        this.uid = map.getNamedItem("uid").getNodeValue();
        this.description = map.getNamedItem("description").getNodeValue();
        if (map.getNamedItem("mathML") != null) {
            this.mathML = map.getNamedItem("mathML").getNodeValue();
        }
        if (map.getNamedItem("codeValue") != null) {
            this.codeValue = map.getNamedItem("codeValue").getNodeValue();
        }
        this.codeMeaning = map.getNamedItem("codeMeaning").getNodeValue();
        this.codingSchemeDesignator = map.getNamedItem("codingSchemeDesignator").getNodeValue();
        if (map.getNamedItem("codingSchemeVersion") != null) {
            this.codingSchemeVersion = map.getNamedItem("codingSchemeVersion").getNodeValue();
        }
        if (map.getNamedItem("algorithmName") != null) {
            this.algorithmName = map.getNamedItem("algorithmName").getNodeValue();
        }
        if (map.getNamedItem("algorithmVersion") != null) {
            this.algorithmVersion = map.getNamedItem("algorithmVersion").getNodeValue();
        }
    }

    public edu.stanford.hakan.aim4api.base.CalculationEntity toAimV4(edu.stanford.hakan.aim4api.base.ImageAnnotation imageAnnotation) {
        edu.stanford.hakan.aim4api.base.CalculationEntity res = new edu.stanford.hakan.aim4api.base.CalculationEntity();
        res.setUniqueIdentifier();
        Algorithm algorithm = new Algorithm();
        algorithm.setName(Converter.toST(this.getAlgorithmName()));
        algorithm.setVersion(Converter.toST(this.getAlgorithmVersion()));
        algorithm.addType(new CD("", "", "", ""));
        res.setAlgorithm(algorithm);
        res.setCalculationResultCollection(this.getCalculationResultCollection().toAimV4());
        res.setDescription(Converter.toST(this.getDescription()));
        res.setMathML(Converter.toST(this.getMathML()));
        CD typeCode = new CD();
        typeCode.setCode(this.getCodeValue());
        typeCode.setCodeSystem(this.getCodeMeaning());
        typeCode.setCodeSystemName(this.getCodingSchemeDesignator());
        typeCode.setCodeSystemVersion(this.getCodingSchemeVersion());
        res.addTypeCode(typeCode);

        if (this.getReferencedCalculationCollection().getReferencedCalculationList().size() > 0) {
            for (edu.stanford.hakan.aim4api.compability.aimv3.ReferencedCalculation itemV3 : this.getReferencedCalculationCollection().getReferencedCalculationList()) {
                edu.stanford.hakan.aim4api.base.CalculationEntityReferencesCalculationEntityStatement annotationStatement = itemV3.toAimV4(this);
                imageAnnotation.addImageAnnotationStatement(annotationStatement);
            }
        }
        if (this.getReferencedGeometricShapeCollection().getReferencedGeometricShapeList().size() > 0) {
            for (edu.stanford.hakan.aim4api.compability.aimv3.ReferencedGeometricShape itemV3 : this.getReferencedGeometricShapeCollection().getReferencedGeometricShapeList()) {
                itemV3.toAimV4(imageAnnotation, res.getUniqueIdentifier());
            }
        }
        return res;
    }
}
