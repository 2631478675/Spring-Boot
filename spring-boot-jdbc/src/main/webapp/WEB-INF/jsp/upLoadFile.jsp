<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <form action="/upload" enctype="multipart/form-data" method="post">
        <!-- 注意：这里name必须为file，不能改-->
        <input type="file" name="file"/>
        <br><br>
        <input type="submit" value="提交上传"/>
    </form>
</body>
</html>