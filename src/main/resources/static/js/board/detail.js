var path = window.location.pathname;
var segments = path.split('/');
var boardId = segments[segments.length - 1];

function init() {
    detail();
}

function detail() {
    $.ajax({
        url: '/board/api/detail/' + boardId,
        type: 'GET',
        data: $('#detailForm').serialize(),
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
    $('#boardId').text(board.boardId)
    $('#writer').text(board.writer)
    $('#title').text(board.title)
    $('#content').text(board.content)
}