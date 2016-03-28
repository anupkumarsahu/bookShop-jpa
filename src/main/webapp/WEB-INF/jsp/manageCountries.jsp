<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BookShop - Manage Countries</title>
        <link rel="stylesheet" href="/BookShop/css/admin.css" type="text/css">
</head>
<body>
        <%@ include file="/WEB-INF/jsp/adminHeader.jsp" %>
        <br/>
        <form:form method="post" action="${pageContext.request.contextPath}/admin/saveCountry" commandName="country">
            <form:hidden path="countryNo" />
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td>
                        <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <tr>
                                <td class="manageForms">Manage Countries</td>
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
                                                <br />Country Details<br /><br />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="10%">Country Name<span class="mandatory">*</span>:</td>
                                            <td>
                                                <form:input path="country" title="Enter the country name" maxlength="25" size="50"/><br>
                                                <form:errors path="country" cssClass="error" />
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr><td>&nbsp;</td></tr>
                            <tr>
                                <td colspan="2" class="centerAlign">
                                    <input type="submit" class="groovybutton" value="Save" />
                                    <input type="reset" value="Clear" class="groovybutton" onclick="javascript:document.location.href='/BookShop/admin/manageCountries'" />
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
        <c:if test="${!empty countryList}">
            <table class="data" width="100%">
                <tr>
                    <th width="94%">Country Name</th>
                    <th width="3%">&nbsp;</th>
                    <th width="3%">&nbsp;</th>
                </tr>
                <c:forEach items="${countryList}" var="country">
                    <tr>
                        <td>${country.country}</td>
                        <td><a href="/BookShop/admin/deleteCountry/${country.countryNo}"><img title="Click to delete" src="/BookShop/images/delete.jpg"/></a></td>
                        <td><a href="/BookShop/admin/editCountry/${country.countryNo}"><img title="Click to edit" src="/BookShop/images/edit.jpg"/></a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <%@ include file="/WEB-INF/jsp/adminFooter.jsp" %>

</body>
</html>