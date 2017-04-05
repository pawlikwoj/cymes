<form method="post" action="${rc.getContextPath()}/login">
    <input type="text" name="email" />
    <input type="password" name="password" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Zaloguj" />
</form>