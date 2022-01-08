//用户名检查
let checkUsernameFlag;
let checkPasswordFlag;
let checkConfirmPasswordFlag;
let checkPhoneFlag;
let checkEmailFlag;
let checkNameFlag;

function checkUsername(){
    checkUsernameFlag=false;
    const username = document.getElementById("username");
    const span=document.getElementById("span_username");
    const re = /^[a-zA-Z_]{6,18}$/;
    if(username.value===""){
        span.innerHTML="<p style='color: red'>用户名不能为空</p>"
    }
    else if(username.value.length < 6 ||username.value.length > 18){
        span.innerHTML="<p style='color: red'>长度应为6-18个字符</p>"
    }
    else if(!re.test(username.value)){
        span.innerHTML="<p style='color: red'>只能包含英文字母和下划线</p>"
    }
    else {
        $('#username').blur(function(){
            $.ajax( {
                url:'checkUsernameServlet',
                data:{
                    username : $(this).val()
                },
                type:'post',
                success:function(data) {
                    if (data==="可以使用"){
                        checkUsernameFlag=true;
                        span.innerHTML="<p style='color: green'>可以使用</p>"
                    }else if (data==="用户名已存在"){
                        span.innerHTML="<p style='color: red'>用户名已存在</p>"
                    }
                }
            });
        })
    }
}
//密码检查
function checkPassword(){
    checkPasswordFlag=false;
    const password = document.getElementById("password");
    const re = /^(?=.*\d)(?=.*[a-zA-Z])[\da-zA-Z]{6,}$/;
    const span=document.getElementById("span_password");
    if(password.value===""){
        span.innerHTML="<p style='color: red'>密码不能为空</p>";
    }
    else if(password.value.length < 6){
        span.innerHTML="<p style='color: red'>密码长度至少为6位</p>"
    }
    else if(!re.test(password.value)){
        span.innerHTML="<p style='color: red'>密码必须包含英文字母大小写和数字</p>"
    }
    else {
        span.innerHTML="<p style='color: green'>密码可用</p>"
        checkPasswordFlag=true;
    }
}
//确认密码
function checkConfirmPassword(){
    checkConfirmPasswordFlag=false;
    const password = document.getElementById("password");
    const confirmPassword = document.getElementById("confirmPassword");
    const span=document.getElementById("span_confirmPassword");
    if(confirmPassword.value===""){
        span.innerHTML="<p style='color: red'>请再次输入密码</p>"
    }
    else if(password.value !== confirmPassword.value){
        span.innerHTML="<p style='color: red'>密码不一致</p>"
    }
    else {
        span.innerHTML="<p style='color: green'>密码一致</p>"
        checkConfirmPasswordFlag=true;
    }
}
//联系电话
function checkPhone(){
    checkPhoneFlag=false;
    const phone = document.getElementById("phone");
    const re = /^1\d{10}$/;
    const span=document.getElementById("span_phone");
    if(phone.value===""){
        span.innerHTML="<p style='color: red'>请输入联系电话</p>"
    }
    else if(!re.test(phone.value)){
        span.innerHTML="<p style='color: red'>电话格式输入错误</p>"
    }
    else {
        span.innerHTML="<p style='color: green'>正确</p>"
        checkPhoneFlag=true;
    }
}
//电子邮箱
function checkEmail(){
    checkEmailFlag=false;
    const email = document.getElementById("email");
    const re = /[a-zA-Z0-9]{1,10}@[a-zA-Z0-9]{1,5}\.[a-zA-Z0-9]{1,5}/;
    const span=document.getElementById("span_email")
    if(email.value===""){
        span.innerHTML="<p style='color: red'>请输入电子邮箱</p>"
    }
    else if(!re.test(email.value)){
        span.innerHTML="<p style='color: red'>邮箱格式不正确</p>"
    }
    else {
        span.innerHTML="<p style='color: green'>邮箱可用</p>"
        checkEmailFlag=true;
    }
}
function checkName(){
    checkNameFlag=false;
    const name=document.getElementById("name");
    const span=document.getElementById("span_name");
    const re = /^[\u4E00-\u9FA5A-Za-z\s]+(·[\u4E00-\u9FA5A-Za-z]+)*$/;
    if (name.value===""){
        span.innerHTML="<p style='color: red'>姓名不能为空</p>"
    }
    else if(!re.test(name.value)){
        span.innerHTML="<p style='color: red'>不合法的姓名</p>"
    }else {
        span.innerHTML="<p style='color: green'>可以使用</p>"
        checkNameFlag=true;
    }
}
//form表单检查
function checkAll(){
    const span=document.getElementById("span_form");
    if(checkUsernameFlag && checkPasswordFlag && checkConfirmPasswordFlag && checkPhoneFlag && checkEmailFlag && checkNameFlag){
        return true;
    }else {
        span.innerHTML="<p style='color: red'>请检查上面字段提示</p>"
        return false;
    }
}