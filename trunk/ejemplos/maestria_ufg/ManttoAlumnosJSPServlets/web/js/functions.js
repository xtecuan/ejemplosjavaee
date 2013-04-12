function disableTextFields(form, combo) {

    for (var i = 0; i < document.forms[form].elements.length; i++) {

        var currentType = document.forms[form].elements[i].type;
        //alert(currentType);
        if (currentType == 'text') {
            document.forms[form].elements[i].disabled = true;
        }
    }
}

function enableTextSearch(form, combo) {

    var whatIndex = document.forms[form].elements[combo].options.selectedIndex;
    var whatValue = document.forms[form].elements[combo].options[whatIndex].value;

    if (whatValue == '') {
        alert('Seleccione una opción de Busqueda');
    } else {
        disableTextFields(form, combo)
        document.forms[form].elements[whatValue].disabled = false;
    }
}