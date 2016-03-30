<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BookShop[Sharanam & Vaishali Shah] - Manage Categories</title>
        <link rel="stylesheet" href="/BookShop/css/admin.css" type="text/css">
    </head>
    <body>
        <%@ include file="/WEB-INF/jsp/adminHeader.jsp" %>
        <br/>
        <form:form method="post" action="${pageContext.request.contextPath}/admin/saveCategory" commandName="category">
            <form:hidden path="categoryNo" />
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td>
                        <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <tr>
                                <td class="manageForms">Manage Categories</td>
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
                                            <td class="sectionName" colspan="2">
                                                <br />Category Details<br /><br />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="10%">Category<span class="mandatory">*</span>:</td>
                                            <td>
                                                <form:input path="category" title="Enter the category name" maxlength="25" size="55"/><br>
                                                <form:errors path="category" cssClass="error" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="10%">Description<span class="mandatory">*</span>:</td>
                                            <td>
                                                <form:textarea path="description" title="Enter the description of the category" cols="80" rows="5"/><br>
                                                <form:errors path="description" cssClass="error" />
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr><td>&nbsp;</td></tr>
                            <tr>
                                <td colspan="2" class="centerAlign">
                                    <input type="submit" class="groovybutton" value="Save" />
                                    <input type="reset" value="Clear" class="groovybutton" onclick="javascript:document.location.href='/BookShop/admin/manageCategories'" />
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
        <c:if test="${!empty categoryList}">
            <table class="data" width="100%">
                <tr>
                    <th width="14%">Category</th>
                    <th width="80%">Description</th>
                    <th width="3%">&nbsp;</th>
                    <th width="3%">&nbsp;</th>
                </tr>
                <c:forEach items="${categoryList}" var="category">
                    <tr>
                        <td>${category.category}</td>
                        <td>${category.description}</td>
                        <td><a href="/BookShop/admin/deleteCategory/${category.categoryNo}"><img title="Click to delete" src="/BookShop/images/Delete.png"/></a></td>
                        <td><a href="/BookShop/admin/editCategory/${category.categoryNo}"><img title="Click to edit" src="/BookShop/images/Edit.png"/></a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <%@ include file="/WEB-INF/jsp/adminFooter.jsp" %>
    </body>
</html>
