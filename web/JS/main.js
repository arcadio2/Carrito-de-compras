
$(function () {

    function validar() {
        var user = document.form.username.value;
        var pass = document.form.password.value;
        var email = document.form.email.value;
        var carac_pass = "QWERTYUIOPASDFGHJKLÑZXCVBNMÍÓÚÉÁ";
        var num_pass = "1234567890";
        var contc = 0;
        var contn = 0;

        var boolean = true;
        var arreglo = [];
        for (var i = 0; i < user.length; i++) {
            arreglo[i] = false;
        }
        var caract = "QWERTYUIOPASDFGHJKLÑZXCVBNMÍÓÚÉÁqwertyuiopasdfghjklñzxcvbnm1234567890 ";
        for (var i = 0; i < user.length; i++) {
            for (var j = 0; j < caract.length; j++) {
                if (user.charAt(i) == caract.charAt(j)) {

                    arreglo[i] = true;
                }
            }
            if (arreglo[i] == false) {
                boolean = false;
            }
        }
        if (boolean == false) {
            document.getElementById("avisos").innerHTML = "El usuario sólo puede contebner números y letras";
            return false;
        } else {
            for (var i = 0; i < pass.length; i++) {
                for (var j = 0; j < carac_pass.length; j++) {
                    if (pass.charAt(i) === carac_pass.charAt(j)) {
                        contc++;
                    }
                }
                for (var k = 0; k < num_pass.length; k++) {
                    if (pass.charAt(i) === num_pass.charAt(k)) {
                        contn++;
                    }
                }
            }//fin del for de la contra
            if (contc < 1 || contn < 1) {
                document.getElementById("avisos").innerHTML = "La contraseña debe tener por lo menos un número y una máyuscula";
                return false;
            } else {
                return true;
            }
        }


    }

    $('#form').validate({
        rules: {
            username: {
                required: true,
                minlength: 3,
                maxlength: 20
            },
            password: {
                required: true,
                minlength: 8,
                maxlength: 50
            },
            rpassword: {
                required: true,
                equalTo: "#password"
            },
            email: {
                required: true,
                email: true
            }

        },
        messages: {
            username: {
                required: "El campo es obligatorio",
                minlength: "Ingresa más de 3 caracteres",
                maxlength: "Sólo puedes ingresar 20 cáracteres"
            },
            password: {
                required: "El campo es obligatorio",
                minlength: "Ingrese como mínimo 8 caracteres",
                maxlength: "No puede ingresar mas de 50 caracteres"
            },
            rpassword: {
                required: "El campo es obligatorio",
                equalTo: "Las contraseñas no coinciden"

            },
            email: {
                required: "El campo es obligatorio",
                email: "No es un Email válido"
            }

        },
        submitHandler: function (form) {

            if (validar()) {
                var data = $("#form").serialize();

                $.post("CrearUsuario", data, function (res, est, jqXHR) {
                    if (res == "1") {
                        $("#username").val("");
                        $("#password").val("");
                        $("#email").val = ("");
                        $("#rpassword").val("");
                        setTimeout(function () {
                            window.location = "IniciarSesion.jsp";
                        }, 300);
                    } else {
                        $("#avisos").html(res);
                    }

                });
            }


            //  form.submit(); 
        }

    });

    $('#inicio').validate({
        rules: {
            defaultLoginFormEmail: {
                required: true
            },
            defaultLoginFormPassword: {
                required: true
            }

        },
        messages: {
            defaultLoginFormEmail: {
                required: "Este campo es requerido"
            },
            defaultLoginFormPassword: {
                required: "Este campo es requerido"
            }
        },
        submitHandler: function (form) {

            var data = $("#inicio").serialize();

            $.post("Login", data, function (res, est, jqXHR) {

                if (res == "4") {
                    $("#defaultLoginFormPassword").val("");
                    $("#myavisos").html("El usuario no existe");
                } else if (res == "3") {
                    $("#defaultLoginFormPassword").val("");
                    $('#myavisos').html("Contraseña incorrecta");
                    //$("#myavisos").val("Contraseña incorrecta"); 

                    // document.getElementById.innerHTML("myavisos")="Contraseña incorrecta"; 
                    //Contraseña incorrecta
                } else if (res == "2") {

                    setTimeout(function () {
                        window.location = "Home.jsp";
                    }, 300);
                } else if (res == "1") {

                    setTimeout(function () {
                        window.location = "admin.jsp";
                    }, 300);
                }
                // $("#defaultLoginFormEmail").val("");


            });

            //  form.submit(); 
        }


    });

});
