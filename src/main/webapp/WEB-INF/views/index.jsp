<%--
  Created by IntelliJ IDEA.
  User: 10340
  Date: 2018/2/9
  Time: 下午 5:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= request.getAttribute("Title") %>
    </title>
    <script src="http://127.0.0.1/statics/node_modules/vue/dist/vue.js"></script>
</head>
<script>
    new Vue({
        beforeMount: function () {
            var app = new Vue({
                el: '#app',
                create:{
                    message: 'Hello Vue!'
                }
            })
        }
    })

</script>
<body>
<div id="app">
    {{ message }}
</div>

</body>
</html>
