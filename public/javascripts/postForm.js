$(document).ready(function(){
    $("form").on("submit testphp", function(e) {
        // Stop form from submitting normally
        e.preventDefault();

        // Eliminate duplication of DOM lookup
        var form = $(this);

        // Stores the form data in HTML format
        var formData = form.serialize();

        // Ajax request to post the form without reloading the page
        $.ajax( {
            url: "http://localhost:8000/" + form.attr("action"),
            type: form.attr("method"),
            data: formData,
            crossDomain: true,
            dataType: 'json',
            contentType: "application/javascript",
            timeout: 3000,
            async: false,
            success: function(response) {
                form.parent().parent().parent().find(".well p").replaceWith("<p>" + response + "</p>");
                form.parent().parent().detach();
            },
            error: function(response) {
                alert("PHPNEW Error");
            }
        })
    })
})