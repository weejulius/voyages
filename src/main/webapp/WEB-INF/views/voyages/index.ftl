[#ftl]
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="${base}"/>
    <title></title>
</head>
<body>
<div>
    [#if voyage??]
    <ul>
        <li>id:${voyage.id()}</li>
        <li>ship name:${voyage.ship().name()}</li>
        <li>status :${voyage.status()}</li>
    </ul>
    [#else]
    no voyages.
    [/#if]
</div>
</body>
</html>