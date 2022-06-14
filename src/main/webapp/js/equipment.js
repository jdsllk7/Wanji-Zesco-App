$(document).ready(function () {

    $("#EquipmentForm").on('submit', function (event) {
        event.preventDefault();
        event.stopPropagation();

        let form = $('#EquipmentForm');

        let formData = new FormData(form[0]);

        $.ajax({
            url: 'equipment',
            type: 'POST',
            data: formData,
            cache: false,
            contentType: false,
            processData: false,
            success: function (response) {
                if (response.status === "success") {
                    Swal.fire({
                        title: 'Success',
                        text: "Equipment saved successfully",
                        icon: 'success',
                        showCancelButton: false,
                        confirmButtonColor: '#3085d6',
                        confirmButtonText: 'Okay'
                    }).then(() => {
                        window.location.href = 'equipment';
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
