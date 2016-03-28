<%@ page language="java" contentType="text/html" import="java.util.*, java.text.SimpleDateFormat" %>
<%
    Date d = new Date();
    Calendar c = Calendar.getInstance();
    c.setTime(d);
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH) + 1;
    int day = c.get(Calendar.DATE);
    String curDate = null;
    curDate = year + "-" + month + "-" + day;
%>
<div id="headerDiv">
    <table class="headerTable" border="0" width="100%">
        <tr>
            <td>
                <h1>Online Bookshop</h1>
            </td>
        </tr>
    </table>
    <br/>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <tr>
            <td width="37%">
                &nbsp;
            </td>
            <td class="menuborder" width="7%">
                <a href="${pageContext.request.contextPath}/admin/manageCountries" title="Manage Countries">Countries</a>
            </td>
            <td class="menuborder" width="7%">
                <a href="${pageContext.request.contextPath}/admin/manageStates" title="Manage States">States</a>
            </td>
            <td class="menuborder" width="7%">
                <a href="${pageContext.request.contextPath}/admin/manageCategories" title="Manage Categories">Categories</a>
            </td>
            <td class="menuborder" width="7%">
                <a href="${pageContext.request.contextPath}/admin/managePublishers" title="Manage Publishers">Publishers</a>
            </td>
            <td class="menuborder" width="7%">
                <a href="${pageContext.request.contextPath}/admin/manageAuthors" title="Manage Authors">Authors</a>
            </td>
            <td class="menuborder" width="7%">
                <a href="${pageContext.request.contextPath}/admin/manageBooks" title="Manage Books">Books</a>
            </td>
            <td class="menuborder" width="7%">
                <a href="${pageContext.request.contextPath}/admin/manageUsers" title="Manage Users">Users</a>
            </td>
            <td class="menuborder" width="7%">
                <a href="${pageContext.request.contextPath}/admin/manageTransactions" title="Manage Transactions">Transactions</a>
            </td>
            <td class="menuborder" width="7%">
                <a href='<c:url value="/admin/j_spring_security_logout" />' title="Logout">Logout</a>
            </td>
        </tr>
    </table>
</div>