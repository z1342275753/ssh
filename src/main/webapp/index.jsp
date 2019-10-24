<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="/login.action">
    查询
    <input type="submit">


</form>
<form action="/save.action">
    保存
    <input type="text" name="student.id">
    <input type="text" name="student.name">
    <input type="text" name="student.password">
    <input type="submit">
</form>
<s:form action="file" enctype="multipart/form-data">
    <s:label for="upload">文件上传</s:label><s:file id="upload"  name="file"/>
    <s:submit/>
</s:form>

</body>
</html>
