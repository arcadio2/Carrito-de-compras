
$(function () {

    function validar() {
        var user = document.form.username.value;
        var pass = document.form.password.value;
        var tipo = document.form.select.value;
        var email = document.form.email.value;
        var carac_pass = "QWERTYUIOPASDFGHJKLÑZXCVBNMÍÓÚÉÁ";
        var num_pass = "1234567890";
        var contc = 0;
        var contn = 0;
        if (tipo != "Panadero" && tipo != "Cajero") {
            $("#avisos").html("Selecciona un tipo");
            return false;
        } else {
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
            email: {
                required: true,
                email: true
            },
            adminpass:{
                required: true
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
            email: {
                required: "El campo es obligatorio",
                email: "No es un Email válido"
            },
             adminpass:{
                required: "El campo es obligatorio"
            }
                    

        },
        submitHandler: function (form) {

            if (validar()) {
                var data = $("#form").serialize();

                $.post("CrearEmpleado", data, function (res, est, jqXHR) {
                    if (res == "1") {
                        $("#username").val("");
                        $("#password").val("");
                        $("#email").val = ("");
                        $("#rpassword").val("");
                        
                        alert("Empleado registrado");
                        
                    } else {
                        $("#avisos").html(res);
                    }

                });
            }


            //  form.submit(); 
        }

    });



});
