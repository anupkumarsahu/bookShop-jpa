<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BookShop[Anup] - Manage Publishers</title>
        <link rel="stylesheet" href="/BookShop/css/admin.css" type="text/css">
    </head>
    <body>
        <%@ include file="/WEB-INF/jsp/adminHeader.jsp" %>
        <br/>
        <form:form method="post" action="${pageContext.request.contextPath}/admin/savePublisher" commandName="publisher">
            <form:hidden path="publisherNo" />
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td>
                        <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <tr>
                                <td class="manageForms">Manage Publishers</td>
                                <td align="center" class="error">${dbError}</td>
                                <td class="information">
                                    It is mandatory to enter information in all information <br>capture boxes which have a <span class="mandatory">*</span> adjacent
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr><td class="hrLine">&nbsp;</td></tr>
                <tr>
                    <td>
                        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td>
                                    <table width="100%" border="0" cellpadding="4" cellspacing="4">
                                        <tr>
                                            <td class="sectionName" colspan="4">
                                                <br />Publisher Details<br /><br />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="10%">Publisher Name<span class="mandatory">*</span>:</td>
                                            <td width="45%">
                                                <form:input path="publisherName" title="Enter the publisher name" maxlength="50" size="55"/><br>
                                                <form:errors path="publisherName" cssClass="error" />
                                            </td width="10%">
                                            <td width="10%">Email Address<span class="mandatory">*</span>:</td>
                                            <td width="45%">
                                                <form:input path="emailAddress" title="Enter the email address" maxlength="50" size="55"/><br>
                                                <form:errors path="emailAddress" cssClass="error" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="sectionName" colspan="4">
                                                <br />Mailing Address<br /><br />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="10%">Address Line 1:</td>
                                            <td width="45%">
                                                <form:input path="address1" title="Enter the street address" maxlength="50" size="55"/>
                                            </td>
                                            <td width="10%">State:</td>
                                            <td width="45%">
                                                <form:select path="stateNo">
                                                    <form:option value="" label="--- Select ---"/>
                                                    <form:options title="Select the state" items="${stateList}" itemValue="stateNo" itemLabel="state" />
                                                </form:select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="10%">Address Line 2:</td>
                                            <td width="45%">
                                                <form:input path="address2" title="Enter the street address" maxlength="50" size="55"/>
                                            </td>
                                            <td width="10%">Country:</td>
                                            <td width="45%">
                                                <form:select path="countryNo">
                                                    <form:option value="" label="--- Select ---"/>
                                                    <form:options title="Select the country" items="${countryList}" itemValue="countryNo" itemLabel="country" />
                                                </form:select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="10%">City:</td>
                                            <td width="45%">
                                                <form:input path="city" title="Enter the city" maxlength="50" size="55"/>
                                            </td>
                                            <td width="10%">Pincode:</td>
                                            <td width="45%">
                                                <form:input path="pincode" title="Enter the pincode" maxlength="15" size="20"/>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr><td>&nbsp;</td></tr>
                            <tr>
                                <td colspan="2" class="centerAlign">
                                    <input type="submit" class="groovybutton" value="Save" />
                                    <input type="reset" value="Clear" class="groovybutton" onclick="javascript:document.location.href='/BookShop/admin/managePublishers'" />
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr><td>&nbsp;</td></tr>
                <tr><td class="hrLine">&nbsp;</td></tr>
                <tr><td><br></td></tr>
            </table>
        </form:form>
        <c:if test="${!empty publisherList}">
            <table class="data" width="100%">
                <tr>
                    <th width="47%">Publisher Name</th>
                    <th width="47%">Email Address</th>
                    <th width="3%">&nbsp;</th>
                    <th width="3%">&nbsp;</th>
                </tr>
                <c:forEach items="${publisherList}" var="publisher">
                    <tr>
                        <td>${publisher.publisherName}</td>
                        <td>${publisher.emailAddress}</td>
                        <td><a href="/BookShop/admin/deletePublisher/${publisher.publisherNo}"><img title="Click to delete" src="/BookShop/images/Delete.png"/></a></td>
                        <td><a href="/BookShop/admin/editPublisher/${publisher.publisherNo}"><img title="Click to edit" src="/BookShop/images/Edit.png"/></a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <%@ include file="/WEB-INF/jsp/adminFooter.jsp" %>
    </body>
</html>
