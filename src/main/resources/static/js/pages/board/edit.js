var queryString = window.location.search;
var urlParams = new URLSearchParams(queryString);
var boardId = urlParams.get("boardId");

$(function () {
    loadBoardInfo();
    eventBinding();
});

function loadBoardInfo() {
    $.ajax({
        url: '/board/api/detail/' + boardId,
        type: 'GET',
        data: $('#editForm').serialize(),
        success: function (response) {
            var board = response;
            if (board != null) {
                setBoardData(board);
            } else {
                $('#datatable tbody').append('데이터가 없습니다.')
            }
        }
    })
}

function setBoardData(board) {
//    $('#boardId').text(board.boardId)
    $('#writer').val(board.writer)
    $('#title').val(board.title)
    $('#content').val(board.content)
}

function eventBinding() {
    $('#updateBtn').on('click', function () {
        update();
    })
}

function update() {
    $.ajax({
        url: '/board/api/edit',
        contentType: "application/json",
        type: 'PUT',
        data: JSON.stringify({
            "boardId" : boardId,
            "title" : $('#title').val(),
            "writer" : $('#writer').val(),
            "content" : $('#content').val()
        })
    });
}