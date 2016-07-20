<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP page</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <%@include file="header.jsp" %>

    <div class="row" id="canvas">
        <div class="col-xs-0 col-sm-0 col-md-1 col-lg-2">
            <!-- empty space to the left-->
        </div>
        <div class="col-xs-6 col-md-4 col-md-10 col-lg-8" id="content">

            <div class="col-xs-3 col-sm-2 col-md-2 col-lg-2" id="left-bar">
                <div class = "panel panel-info">

                <h4>What is Lorem Ipsum?</h4>
                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                </div>

                <div class = "panel panel-info">
                    <h4>Where does it come from?</h4>
                    <p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.</p>
                    <p>The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.</p>
                </div>
            </div>
            <div class="col-xs-9 col-sm-10 col-md-10 col-lg-10" id="main">
                <div class="row" id="content-header">
                    <div class="row panel panel-info" id="canvas" >
                        <h1><%= request.getAttribute("model") %></h1>
                    </div>
                </div>
                <div class="row">
                    <div class="row panel panel-info">

                        <div class="col-xs-6 col-sm-4 col-md-3 col-lg-3 panel panel-info" >
                            product
                        </div>
                        <div class="col-xs-6 col-sm-4 col-md-3 col-lg-3 panel panel-info" >
                            product
                        </div>
                        <div class="col-xs-6 col-sm-4 col-md-3 col-lg-3 panel panel-info" >
                            product
                        </div>
                        <div class="col-xs-6 col-sm-4 col-md-3 col-lg-3 panel panel-info" >
                            product
                        </div>
                        product row

                    </div>
                    <div class="row panel panel-info">
                        another product row
                    </div>
                    <div class="row panel panel-info">
                        another product row
                    </div>
                </div>
            </div>

        </div>
        <div class="col-xs-0 col-sm-0 col-md-1 col-lg-2">
            <!-- empy space to the right-->
        </div>
    </div>


</body>
</html>
