$(document).ready(function () {

    $("#LoginForm").on('submit', function (event) {
        event.preventDefault();
        event.stopPropagation();

        let form = $('#LoginForm');

        let formData = new FormData(form[0]);

        $.ajax({
            url: 'login',
            type: 'POST',
            data: formData,
            cache: false,
            contentType: false,
            processData: false,
            success: function (response) {
                if (response.status === "success") {
                    window.location.href = 'dashboard';
                } else if (response.status === "error") {
                    Swal.fire('Error', response.message, response.status);
                }
            },
            error: function (response) {

            }
        });
        return false;
    });
});
