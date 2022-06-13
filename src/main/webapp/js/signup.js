$(document).ready(function () {

    $("#SignupForm").on('submit', function (event) {
        event.preventDefault();
        event.stopPropagation();

        let form = $('#SignupForm');

        let formData = new FormData(form[0]);

        $.ajax({
            url: 'signup',
            type: 'POST',
            data: formData,
            cache: false,
            contentType: false,
            processData: false,
            success: function (response) {
                if (response.status === "success") {
                    Swal.fire({
                        title: 'Success',
                        text: "Account created successfully",
                        icon: 'success',
                        showCancelButton: false,
                        confirmButtonColor: '#3085d6',
                        confirmButtonText: 'Okay'
                    }).then(() => {
                        window.location.href = 'dashboard';
                    })
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
