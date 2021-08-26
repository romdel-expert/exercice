var PASSWOR_LENGTH=8;


/**
 * 
 * @param {type} str
 * @returns {Boolean}
 * vérification de la longuer de la chaine du mot de passe
 */
function pwLength(str){
    var is_good_length=false;
    if(str.length>=PASSWOR_LENGTH){
        is_good_length=true;
    }else{
       is_good_length=false; 
    }
    return is_good_length;
};




/**
 * 
 * @param {type} str
 * @returns {isUperCase|Boolean}
 * verification pour savoir si une chaine contient au moins une lettre majuscule
 */
function checkUperCase(str){
    //var str = "AbcDEFgH";
    isUperCase=false;
    if (str.match(/[A-Z]/, 'g')) {
      isUperCase=true;
    } else {
      isUperCase=false;
    }
    return isUperCase;
};



/**
 * 
 * @param {type} str
 * @returns {Boolean}
 * verification pour savoir si une chaine contient un chiffre
 */
function checkNumeric(str){
    var isNumber=false;
    if(/\d/.test(str)){
        isNumber=true;
    }else{
        isNumber=false;
    }
    return isNumber;
};




/**
 * 
 * @param {type} str
 * @returns {Boolean}
 * verification de la validité du mot de passe en fonction des criteres predefinis
 */
function pwValid(str){
    var isPwValid=false;
    if(pwLength(str) && checkUperCase(str) && checkNumeric(str)){
        isPwValid=true;
    }else{
       isPwValid=false; 
    }
    return isPwValid;
};






/**
 * 
 * @param {type} email
 * @returns {Boolean}
 * cette fonction permets de valider l'adresse email entrée par unn 
 * utilisateur lors d'une inscro-iption
 */
function validateEmail(email) {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}
