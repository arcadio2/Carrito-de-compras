$(function () {

    function validarus() {
        var user = document.modnom.cnom.value;
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
            document.getElementById("error").innerHTML = "El usuario sólo puede contebner números y letras";
            return false;
        } else {
            return true; 
        }


    }
    
    function validarcon(){
        var pass = document.mpass.cpassword.value;
        var carac_pass = "QWERTYUIOPASDFGHJKLÑZXCVBNMÍÓÚÉÁ";
        var num_pass = "1234567890";
        var contc = 0;
        var contn = 0;
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
                document.getElementById("error2").innerHTML = "La contraseña debe tener por lo menos un número y una máyuscula";
                return false;
            } else {
                return true;
            }
        
    }

    $('#modnom').validate({
        rules: {
            cnom: {
                required: true,
                minlength: 3,
                maxlength: 20
            },
            password: {
                required: true
            }

        },
        messages: {
            cnom: {
                required: "El campo es obligatorio",
                minlength: "Ingresa más de 3 caracteres",
                maxlength: "Sólo puedes ingresar 20 cáracteres"
            },
            password: {
                required: "El campo es obligatorio",
                minlength: "Ingrese como mínimo 8 caracteres",
                maxlength: "No puede ingresar mas de 50 caracteres"
            }

        },
        submitHandler: function (form) {
            if (validarus()) {
                var data = $("#modnom").serialize();
        
                $.post("Modificiar", data, function (res, est, jqXHR) {
                    if (res == "1") {
                        alert("Cambiado exitosamente");
                        $("#cnom").val("");
                        $("#password").val("");
                        setTimeout(function () {
                            window.location = "Modificar.jsp";
                        }, 300);
                    } else {
                        $("#error").html(res);
                    }

                });
            }
        }
    });
    
    
    $('#mpass').validate({
        rules: {
            cpassword: {
                required: true,
                minlength: 8,
                maxlength: 30
            },
            apassword: {
                required: true
            }

        },
        messages: {
            cpassword: {
                required: "El campo es obligatorio",
                minlength: "Ingresa más de 3 caracteres",
                maxlength: "Sólo puedes ingresar 30 cáracteres"
            },
            apassword: {
                required: "El campo es obligatorio"
            }

        },
        submitHandler: function (form) {
            if (validarcon()) {
                var data = $("#mpass").serialize();
        
                $.post("Modificiar", data, function (res, est, jqXHR) {
                    if (res == "1") {
                        alert("Cambiado exitosamente");
                        $("#username").val("");
                        $("#password").val("");
                        setTimeout(function () {
                            window.location = "Modificar.jsp";
                        }, 300);
                    } else {
                        $("#error2").html(res);
                    }

                });
            }
        }
    });

    

});
