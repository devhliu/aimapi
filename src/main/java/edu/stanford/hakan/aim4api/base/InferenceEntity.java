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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
*
* @author localadmin
*/
public class InferenceEntity extends Entity
{

public InferenceEntity()
{
setXsiType("InferenceEntity");
}

private Boolean imageEvidence;
private Boolean isPresent;
private List<CD> listTypeCode = new ArrayList<CD>();
private List<CD> listQuestionTypeCode = new ArrayList<CD>();
private Double annotatorConfidence;
private ST description;
private ST label;
private Integer questionIndex;
private ST comment;

public Boolean getImageEvidence()
{
return imageEvidence;
}

public void setImageEvidence(Boolean imageEvidence)
{
this.imageEvidence = imageEvidence;
}

public Boolean getIsPresent()
{
return isPresent;
}

public void setIsPresent(Boolean isPresent)
{
this.isPresent = isPresent;
}

public List<CD> getListTypeCode()
{
return this.listTypeCode;
}

public void setTypeCode(List<CD> listTypeCode)
{
this.listTypeCode = listTypeCode;
for (int i = 0; i < this.listTypeCode.size(); i++) {
this.listTypeCode.get(i).setTagName("typeCode");
}
}

public void addTypeCode(CD newTypeCode)
{
newTypeCode.setTagName("typeCode");
this.listTypeCode.add(newTypeCode);
}

public List<CD> getListQuestionTypeCode()
{
return this.listQuestionTypeCode;
}

public void setQuestionTypeCode(List<CD> listQuestionTypeCode)
{
this.listQuestionTypeCode = listQuestionTypeCode;
for (int i = 0; i < this.listQuestionTypeCode.size(); i++) {
this.listQuestionTypeCode.get(i).setTagName("questionTypeCode");
}
}

public void addQuestionTypeCode(CD newQuestionTypeCode)
{
newQuestionTypeCode.setTagName("questionTypeCode");
this.listQuestionTypeCode.add(newQuestionTypeCode);
}

public Double getAnnotatorConfidence()
{
return annotatorConfidence;
}

public void setAnnotatorConfidence(Double annotatorConfidence)
{
this.annotatorConfidence = annotatorConfidence;
}

public ST getDescription()
{
return description;
}

public void setDescription(ST description)
{
description.setTagName("description");
this.description = description;
}

public ST getLabel()
{
return label;
}

public void setLabel(ST label)
{
label.setTagName("label");
this.label = label;
}

public Integer getQuestionIndex()
{
return questionIndex;
}

public void setQuestionIndex(Integer questionIndex)
{
this.questionIndex = questionIndex;
}

public ST getComment()
{
return comment;
}

public void setComment(ST comment)
{
comment.setTagName("comment");
this.comment = comment;
}

@Override
public Node getXMLNode(Document doc) throws AimException
{
if (getTagName() == null || "".equals(getTagName())) {
setTagName("InferenceEntity");
}
Element res = (Element)super.getXMLNode(doc);
if (this.imageEvidence != null) {
Element el_imageEvidence = doc.createElement("imageEvidence");
el_imageEvidence.setAttribute("value", this.imageEvidence.toString());
res.appendChild(el_imageEvidence);
}
if (this.isPresent != null) {
Element el_isPresent = doc.createElement("isPresent");
el_isPresent.setAttribute("value", this.isPresent.toString());
res.appendChild(el_isPresent);
}
if (this.listTypeCode.size() > 0) {
for (int i = 0; i < this.listTypeCode.size(); i++) {
res.appendChild(this.listTypeCode.get(i).getXMLNode(doc));
}
}
if (this.listQuestionTypeCode.size() > 0) {
for (int i = 0; i < this.listQuestionTypeCode.size(); i++) {
res.appendChild(this.listQuestionTypeCode.get(i).getXMLNode(doc));
}
}
if (this.annotatorConfidence != null) {
Element el_annotatorConfidence = doc.createElement("annotatorConfidence");
el_annotatorConfidence.setAttribute("value", this.annotatorConfidence.toString());
res.appendChild(el_annotatorConfidence);
}
if (this.description != null) {
res.appendChild(this.description.getXMLNode(doc));
}
if (this.label != null) {
res.appendChild(this.label.getXMLNode(doc));
}
if (this.questionIndex != null) {
Element el_questionIndex = doc.createElement("questionIndex");
el_questionIndex.setAttribute("value", this.questionIndex.toString());
res.appendChild(el_questionIndex);
}
if (this.comment != null) {
res.appendChild(this.comment.getXMLNode(doc));
}
return res;
}

@Override
public void setXMLNode(Node node)
{
super.setXMLNode(node);
this.listTypeCode.clear();
this.listQuestionTypeCode.clear();
NodeList listChilds = node.getChildNodes();
for (int i = 0; i < listChilds.getLength(); i++) {
Node currentNode = listChilds.item(i);
if ("imageEvidence".equals(currentNode.getNodeName())) {
this.imageEvidence = Boolean.parseBoolean(currentNode.getAttributes().getNamedItem("value").getNodeValue());
}
if ("isPresent".equals(currentNode.getNodeName())) {
this.isPresent = Boolean.parseBoolean(currentNode.getAttributes().getNamedItem("value").getNodeValue());
}
if ("typeCode".equals(currentNode.getNodeName())) {
CD obj = new CD();
obj.setXMLNode(currentNode);
this.addTypeCode(obj);
}
if ("questionTypeCode".equals(currentNode.getNodeName())) {
CD obj = new CD();
obj.setXMLNode(currentNode);
this.addQuestionTypeCode(obj);
}
if ("annotatorConfidence".equals(currentNode.getNodeName())) {
this.annotatorConfidence = Double.parseDouble(currentNode.getAttributes().getNamedItem("value").getNodeValue());
}
if ("description".equals(currentNode.getNodeName())) {
ST obj = new ST();
obj.setXMLNode(currentNode);
this.setDescription(obj);
}
if ("label".equals(currentNode.getNodeName())) {
ST obj = new ST();
obj.setXMLNode(currentNode);
this.setLabel(obj);
}
if ("questionIndex".equals(currentNode.getNodeName())) {
this.questionIndex = Integer.parseInt(currentNode.getAttributes().getNamedItem("value").getNodeValue());
}
if ("comment".equals(currentNode.getNodeName())) {
ST obj = new ST();
obj.setXMLNode(currentNode);
this.setComment(obj);
}
}
}

@Override
public Node getRDFNode(Document doc, String unquieID, String Prefix) throws AimException
{
throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools
// | Templates.
}

@Override
public boolean isEqualTo(Object other)
{
InferenceEntity oth = (InferenceEntity)other;
if (this.imageEvidence == null ? oth.imageEvidence != null : !this.imageEvidence.equals(oth.imageEvidence)) {
return false;
}
if (this.isPresent == null ? oth.isPresent != null : !this.isPresent.equals(oth.isPresent)) {
return false;
}
if (this.listTypeCode.size() != oth.listTypeCode.size()) {
return false;
}
for (int i = 0; i < this.listTypeCode.size(); i++) {
if (this.listTypeCode.get(i) == null ? oth.listTypeCode.get(i) != null : !this.listTypeCode.get(i).isEqualTo(oth.listTypeCode.get(i))) {
return false;
}
}
if (this.listQuestionTypeCode.size() != oth.listQuestionTypeCode.size()) {
return false;
}
for (int i = 0; i < this.listQuestionTypeCode.size(); i++) {
if (this.listQuestionTypeCode.get(i) == null ? oth.listQuestionTypeCode.get(i) != null : !this.listQuestionTypeCode.get(i).isEqualTo(oth.listQuestionTypeCode.get(i))) {
return false;
}
}
if (this.annotatorConfidence == null ? oth.annotatorConfidence != null : !this.annotatorConfidence
.equals(oth.annotatorConfidence)) {
return false;
}
if (this.description == null ? oth.description != null : !this.description.isEqualTo(oth.description)) {
return false;
}
if (this.label == null ? oth.label != null : !this.label.isEqualTo(oth.label)) {
return false;
}
if (this.questionIndex == null ? oth.questionIndex != null : !this.questionIndex.equals(oth.questionIndex)) {
return false;
}
if (this.comment == null ? oth.comment != null : !this.comment.isEqualTo(oth.comment)) {
return false;
}
return super.isEqualTo(other);
}

@Override
public InferenceEntity getClone()
{
InferenceEntity res = new InferenceEntity();
if (this.getImageEvidence() != null) {
res.setImageEvidence(this.getImageEvidence());
}
if (this.getIsPresent() != null) {
res.setIsPresent(this.getIsPresent());
}
for (int i = 0; i < this.listTypeCode.size(); i++) {
if (this.listTypeCode.get(i) != null) {
res.addTypeCode(this.listTypeCode.get(i).getClone());
}
}
for (int i = 0; i < this.listQuestionTypeCode.size(); i++) {
if (this.listQuestionTypeCode.get(i) != null) {
res.addQuestionTypeCode(this.listQuestionTypeCode.get(i).getClone());
}
}
if (this.getAnnotatorConfidence() != null) {
res.setAnnotatorConfidence(this.getAnnotatorConfidence());
}
if (this.getDescription() != null) {
res.setDescription(this.getDescription().getClone());
}
if (this.getLabel() != null) {
res.setLabel(this.getLabel().getClone());
}
if (this.getQuestionIndex() != null) {
res.setQuestionIndex(this.getQuestionIndex());
}
if (this.getComment() != null) {
res.setComment(this.getComment().getClone());
}
if (this.getUniqueIdentifier() != null) {
res.setUniqueIdentifier(this.getUniqueIdentifier().getClone());
}
if (this.getTagName() != null) {
res.setTagName(this.getTagName());
}
if (this.getXsiType() != null) {
res.setXsiType(this.getXsiType());
}
return res;
}
}
