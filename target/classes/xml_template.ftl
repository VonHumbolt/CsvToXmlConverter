<users>
<#list users as user>
    <user>
        <username>${user.username}</username>
        <firstname>${user.firstname}</firstname>
        <lastname>${user.lastname}</lastname>
        <email>${user.email}</email>
        <roles>
        <#list user.roles as role>
            <role>${role}</role>
        </#list>
        </roles>
    </user>
</#list>
</users>