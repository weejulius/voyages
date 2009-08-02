[#ftl]
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="${base}"/>
    <title></title>
</head>
<body>
<form action="voyage/new" method="post">
    <div>

        [#if ships??]
        <select name="ship">
            [#list ships as ship]
            <option value="${ship.id()?string}">${ship.name()}</option>
            [/#list]
        </select>
        [#else]
        no ships
        [/#if]

        <input type="submit" value="<new voyage>"/>
    </div>
</form>
</body>
</html>