login = function () {
    email = document.input.email.value;
    senha = document.input.senha.value;
    senha = btoa(senha);

    alert(senha)

    $.ajax({
        url:"/ImersaoSeguranca/rest/usuario/logar",
        type: "POST",
        data: "email="+email+"&senha="+senha,
        success : function (msg) {
            alert(msg);
        },
        error : function (msg) {
            alert(msg)
        }

    })

}