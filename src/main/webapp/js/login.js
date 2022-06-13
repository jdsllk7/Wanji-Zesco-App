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
            success: function (data) {

                setTimeout(function () {
                    swal({
                            title: "File Upload",
                            text: data.message,
                            type: "success",
                            showCancelButton: false,
                            confirmButtonClass: "btn btn-success",
                            confirmButtonText: "OK",
                            closeOnConfirm: true
                        },
                        function () {
                        });
                }, 200);

            },
            error: function (data) {
                if (data.hasOwnProperty("responseJSON")) {
                    swal("Error Submitting", data.responseJSON.message, "error")
                }
            }
        });
        return false;
    });
});
