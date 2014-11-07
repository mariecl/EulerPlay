$(document).ready(function(){
    $("form").on("click", ".phpPost", function(e) {
        // Stop form from submitting normally
        e.preventDefault();

        // Eliminate duplication of DOM lookup
        var form = $(this).closest("form");

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
                // Changes the text at the top of the page to the AJAX response
                $("#pageMessage").text(response);
                // Removes form and its style holders
                $("#formHolder").detach();
            },
            error: function(response) {
                alert("Error with the PHP response handler.");
            }
        });
    });
});