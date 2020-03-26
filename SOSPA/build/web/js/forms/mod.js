

function moduser(){
    var nomus=document.modnom.cnom.value;
    var pass=document.modnom.password.value;
    var test = true; 
    var hmm="@°|¬!#$%&/()=?'¿¡:.;,+*~}]{['"; 

   // let regex = /^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$/g;
    if (nomus.length<1 || pass.length<1) {
        document.getElementById("error").innerHTML="Debes rellenar todos los datos";
        return false; 
    }
    if (nomus.length<4 || nomus.length>30) {
        document.getElementById("error").innerHTML="El nombre de usuario debe estar entre 3 y 30 cáracteres";
        return false; 
    }
    for (var i = 0; i < nomus.length; i++) {
        for (var j = 0; j < hmm.length; j++) {
            if (nomus.charAt(i)===hmm.charAt(j) || nomus.charAt(i)==='"') {
                test=false; 
            }
        }
    }
    if (test===false) {
        document.getElementById("error").innerHTML="El nombre de usuario sólo permite números y letras";
        return false; 
        
    }
   /** if (!nomus.test(regex)) {
        document.getElementById("error").innerHTML="Nombre invalido, solo numeros y letras";
        return false; 
    }*/
}

function modpass(){
    var newpass=document.mpass.cpassword.value; 
    var oldpass=document.mpass.apassword.value; 
     var carac_pass="QWERTYUIOPASDFGHJKLÑZXCVBNMÍÓÚÉÁ"; 
    var num_pass="1234567890"; 
    contc=0; 
    contn=0; 
    if (newpass.length<1 || oldpass.length<1) {
        document.getElementById("error2").innerHTML="Debes rellenar todos los espacios";
        return false; 
    }
    if (oldpass.length<9) {
        document.getElementById("error2").innerHTML="La contraseña debe tener por lo menos 8 caracteres"; 
        return false;
    }
    for (var i = 0; i < oldpass.length; i++) {
        for (var j = 0; j < carac_pass.length; j++) {
            if (oldpass.charAt(i)===carac_pass.charAt(j)) {
                contc++; 
            }
        }
        for (var k = 0; k < num_pass.length; k++) {
            if (oldpass.charAt(i)===num_pass.charAt(k)) {
                contn++; 
            }
        }
    }//fin del for de la contra
    if (contc<1 || contn<1) {
         document.getElementById("error2").innerHTML="La contraseña debe tener por lo menos un número y una máyuscula"; 
        return false;
    }
    
}

function modcom(){
    var com=document.ncom.newcom.value;
    var pass=document.ncom.apassword.value; 
    if (pass.length<1) {
        document.getElementById("error3").innerHTML="Debes escribir tu contraseña";
        return false;
    }
    if (com.length<1) {
        document.getElementById("error3").innerHTML="Invalido";
        return false;
    }
    if (com!=="Ectomorfo" && com!=="Mesomorfo" && com!=="Endomorfo") {
        document.getElementById("error3").innerHTML="Tipo de cuerpo invalido";
        return false;
    }
    
}