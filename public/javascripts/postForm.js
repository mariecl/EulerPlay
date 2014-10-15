$(document).ready(function(){
    $("form").on("submit", function(e) {
        // Stop form from submitting normally
        e.preventDefault();

        // Eliminate duplication of DOM lookup
        var form = $(this);
        var formParent = $(this).parent();
        var formData = form.serialize();

        $.ajax( {
        url: form.attr("action"),
        type: form.attr("method"),
        data: formData,
        dataType: 'html',
        timeout: 3000,
        success: function(response) {
            form.parent().parent().parent().find(".well").find("p").replaceWith("<p>" + response + "</p>");
            form.parent().parent().detach();
        },
        error: function(response) {
            alert("Error");
            }
        })
    })
})
