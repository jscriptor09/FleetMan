<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Vehicles page</h1>

<ul>
<c:forEach items="${vehicles}" var="vehicle">
   <li>${vehicle}</li>
</c:forEach>
</ul>