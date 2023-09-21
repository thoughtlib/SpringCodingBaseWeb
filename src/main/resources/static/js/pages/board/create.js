$(function () {
    eventBinding();
});

function eventBinding() {
    $('#createBtn').on('click', function () {
        create();
    })
}

function create() {
    $.ajax({
        url: '/board/api/create',
        contentType: "application/json",
        type: 'POST',
        data: JSON.stringify({
            "title" : $('#title').val(),
            "writer" : $('#writer').val(),
            "content" : $('#content').val()
        })
    });
}