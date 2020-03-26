
function registro(){
    var name=document.form_reg.nomus.value; 
    var pass=document.form_reg.password.value; 
    var email=document.form_reg.email.value;
    var carac_let="qwertyuiopasdfghjklñzxcvbnmáéíóúüÜQWERTYUIOPASDFGHJKLÑZXCVBNMÍÓÚÉÁ";
    var carac_pass="QWERTYUIOPASDFGHJKLÑZXCVBNMÍÓÚÉÁ"; 
    var num_pass="1234567890"; 
    contc=0; 
    contn=0; 
    var hmm="@°|¬!#$%&/()=?'¿¡:.;,+*~}]{['"; 
    var test=true; 
    
    
    if (name.length<1 || pass.length<1 || email.length<1) {
        document.getElementById("error_reg").innerHTML="Es necesario rellenar todos los campos"; 
        return false; 
    }
    if (name.length<3 || name.length>30) {
        document.getElementById("error_reg").innerHTML="El nombre debe tener entre 3 y 30 caracteres"; 
        return false;
    }
    
    if (pass.length<9) {
        document.getElementById("error_reg").innerHTML="La contraseña debe tener por lo menos 8 caracteres"; 
        return false;
    }
    for (var i = 0; i < name.length; i++) {
        for (var j = 0; j < hmm.length; j++) {
            if (name.charAt(i)===hmm.charAt(j) || name.charAt(i)==='"') {
                test=false; 
            }
        }
    }
    if (test===false) {
        document.getElementById("error_reg").innerHTML="El nombre de usuario sólo permite números y letras";
        return false; 
        
    }
    
   /* if (nameent===false) {
         document.getElementById("error_reg").innerHTML="El nombre sólo debe tener letras"; 
        return false;
    }*/
    for (var i = 0; i < pass.length; i++) {
        for (var j = 0; j < carac_pass.length; j++) {
            if (pass.charAt(i)===carac_pass.charAt(j)) {
                contc++; 
            }
        }
        for (var k = 0; k < num_pass.length; k++) {
            if (pass.charAt(i)===num_pass.charAt(k)) {
                contn++; 
            }
        }
    }//fin del for de la contra
    if (contc<1 || contn<1) {
         document.getElementById("error_reg").innerHTML="La contraseña debe tener por lo menos un número y una máyuscula"; 
        return false;
    }
    alert(contc+" "+contn);
    
    
}

function inciar(){
    var nom=document.inicio.nomusu.value; 
    var pass=document.inicio.pass.value; 
    if (nom.length<1 || pass.length<1) {
        document.getElementById("avisos-inicio").innerHTML="Debes escribir algo";
        return false; 
    }
}


