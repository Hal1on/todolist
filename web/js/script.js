function scriptEdit(formName) {
    var serializeField = "#" + formName;
    $(document).ready(function () {
        $.ajax({
            url: 'controller',
            type: 'POST',
            data: $(serializeField).serialize(),
            success: function suc(response) {
                $(serializeField).html(response);
            }
        });
        return false;

    });
}