function EnterSubproducto(event) {
    if (event.keyCode == 13) {
        ValidaSubproducto();
    }
}
function EnterSubproductoM(event) {
    if (event.keyCode == 13) {
        ValidaSubproductoModifica();
    }
}
function EnterUsuario(event) {
    if (event.keyCode == 13) {
        ValidaUsuario();
    }
}
function ValidaSubproducto() {
    var producto, subproducto, url, precio, stock;
    var valido = true;
    producto = document.getElementById('subproducto-1').value;
    subproducto = document.getElementById('subproducto-2').value;
    url = document.getElementById('subproducto-3').value;
    precio = document.getElementById('subproducto-4').value;
    stock = document.getElementById('subproducto-5').value;
    if (false) {
        valido = false;
        toastr.options = {
            "closeButton": false,
            "debug": false,
            "newestOnTop": false,
            "progressBar": true,
            "positionClass": "toast-top-center",
            "preventDuplicates": true,
            "onclick": null,
            "showDuration": "300",
            "hideDuration": "1000",
            "timeOut": "5000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        }
        toastr.warning("Favor de llenar y seleccionar todos los campos", "Campos vacios");
    }
    if (valido) {
        toastr.options = {
            "closeButton": false,
            "debug": false,
            "newestOnTop": false,
            "progressBar": true,
            "positionClass": "toast-top-center",
            "preventDuplicates": true,
            "onclick": null,
            "showDuration": "300",
            "hideDuration": "1000",
            "timeOut": "5000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        }
        toastr.success("Subproducto añadido");
        document.getElementById('subproducto').submit();
    }
}
function ValidaSubproductoModifica() {
    var subproducto, url;
    var valido = true;
    subproducto = document.getElementById('subproducto-2').value;
    url = document.getElementById('subproducto-3').value;
    if (subproducto.length < 1 || url.length < 1) {
        valido = false;
        toastr.options = {
            "closeButton": false,
            "debug": false,
            "newestOnTop": false,
            "progressBar": true,
            "positionClass": "toast-top-center",
            "preventDuplicates": true,
            "onclick": null,
            "showDuration": "300",
            "hideDuration": "1000",
            "timeOut": "5000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        }
        toastr.warning("Favor de llenar y seleccionar todos los campos", "Campos vacios");
    }
    if (valido) {
        toastr.options = {
            "closeButton": false,
            "debug": false,
            "newestOnTop": false,
            "progressBar": true,
            "positionClass": "toast-top-center",
            "preventDuplicates": true,
            "onclick": null,
            "showDuration": "300",
            "hideDuration": "1000",
            "timeOut": "5000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        }
        toastr.success("Subproducto modificado");
        document.getElementById('subproducto').submit();
    }
}
function ValidaUsuarioModifica() {
    var nombre, correo, contraseña, confirma;
    var valido = true;
    nombre = document.getElementById('subproducto-2').value;
    correo = document.getElementById('subproducto-3').value;
    contraseña = document.getElementById('subproducto-4').value;
    confirma = document.getElementById('subproducto-5').value;
    if (nombre.length < 1 || correo.length < 1 || contraseña.length < 1 || confirma.length < 1) {
        valido = false;
        toastr.options = {
            "closeButton": false,
            "debug": false,
            "newestOnTop": false,
            "progressBar": true,
            "positionClass": "toast-top-center",
            "preventDuplicates": true,
            "onclick": null,
            "showDuration": "300",
            "hideDuration": "1000",
            "timeOut": "5000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        }
        toastr.warning("Favor de llenar y seleccionar todos los campos", "Campos vacios");
    }
    if (confirma != contraseña) {
        valido = false;
        toastr.options = {
            "closeButton": false,
            "debug": false,
            "newestOnTop": false,
            "progressBar": true,
            "positionClass": "toast-top-center",
            "preventDuplicates": true,
            "onclick": null,
            "showDuration": "300",
            "hideDuration": "1000",
            "timeOut": "5000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        }
        toastr.warning("Las contraseñas no coinciden", "Campos incoherentes");
    }
    if (valido) {
        toastr.options = {
            "closeButton": false,
            "debug": false,
            "newestOnTop": false,
            "progressBar": true,
            "positionClass": "toast-top-center",
            "preventDuplicates": true,
            "onclick": null,
            "showDuration": "300",
            "hideDuration": "1000",
            "timeOut": "5000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        }
        toastr.success("usuario modificado");
        document.getElementById('subproducto').submit();
    }
}