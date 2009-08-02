[#ftl]
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
</head>
<body>

[#if (voyages?size)>0]
<h3>index/page :${page.index()}/${page.maxIndex()}</h3>
<ul>
    [#list voyages as voyage]
    <li>id:${voyage.id()}   |   ship name:${voyage.ship().name()}   |    status :${voyage.status()}</li> 
    [/#list]
</ul>
[#else]
no voyages.
[/#if]
</body>
</html>