<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Countries</title>
</head>
<body>
	<h1>Country Listing</h1>
	<form>
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
	</form>
	
</body>
</html>