var number;
var usedId = [1];
var removedId = [];
$(document).ready(function(){
    $("form").on("click", ".add_button", function (e) {
        e.preventDefault();
        if(usedId.length < 5) {
            if (removedId.length !== 0) {
                removedId.sort();
                number = removedId.shift();

            } else {
                number = usedId.length + 1;
            };
            usedId.push(number);
            $(this).parent().before(
                '<fieldset name='+ number +'>' +
                    '<legend>Parameter ' + number + " " + '<button type="button" class="btn btn-sm btn-link remove_button" style="float: right;">Delete</button>'+ '</legend>' +

                    '<div class="form-group">' +
                        '<label>Parameter name</label>' +
                        '<input class="form-control" type="text" name="parameterName_' + number +'" required placeholder="Enter text">'+
                        '<p class="help-block">Needs to be computer readable.</p>' +
                    '</div>' +

                    '<div class="form-group">' +
                        '<label>Proper parameter name</label>' +
                        '<input class="form-control" type="text" name="parameterProperName_' + number + '" required placeholder="Enter text">'+
                        '<p class="help-block">Needs to be human readable.</p>' +
                    '</div>' +

                    '<div class="form-group">' +
                        '<label>Default value</label>' +
                        '<input class="form-control" type="number" name="parameterDefaultValue_' + number +'" required placeholder="Enter value">' +
                        '<p class="help-block">Enter the default value for the parameter. The default value is used when the problem is first loaded.</p>' +
                    '</div>' +
                '</fieldset>')
        } else {
            $(this).replaceWith('<p class="replaced_button">You can only add up to 5 parameters. Try simplifying your question or delete a created parameter. </p>')
        }
    return false;
    });
    $("form").on("click", ".remove_button", function (e) {
        e.preventDefault();

        // Add add_button if it was hidden (removing a parameter allows to create a new one)
        if (!usedId.length < 5) {
            $(this).parent().parent().parent().find("p .replaced_button").replaceWith('<p>' + '<button type="button" class="btn btn-sm btn-default add_button">Add a new parameter</button>' + '</p>');
        };

        // Add parameter id to the list of removed parameters
        removedId.push($(this).parent().parent().attr("name"));
        // Remove parameter id from the list of used id
        for (var i = 0; i < usedId.length; i ++) {
            if (usedId[i] == $(this).parent().parent().attr("name")) {
                usedId.splice(i, 1);
            }
        };
        // Remove user selected fieldset from the form
        $(this).parent().parent().remove();

        return false;
    });
});
