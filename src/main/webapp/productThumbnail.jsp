<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3 panel panel-info" >
    <h4>${requestScope.product.name}</h4>
    <img src="${requestScope.product.imagePath}" width="100%" >
    <p>
        ${requestScope.product.description}
    </p>
    <div>
        <ul>
            <c:forEach items="${requestScope.product.attributes}" var="attribute">
                <li>${attribute.key} * ${attribute.value}</li>
            </c:forEach>
        </ul>
    </div>
    <div>Price : ${requestScope.product.price} </div>

</div>
