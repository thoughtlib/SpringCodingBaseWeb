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
                $('#datatable tbody').append(makeHtml(board))
            }
        }
    })
}

function makeHtml(board) {
    var html = '';

    html += template(board);

    return html;
}

function template(board) {
    var template = '';

    template += '<tr>';
    template += '  <td>' + board.boardId + '</td>';
    template += '  <td>' + board.title +'</td>';
    template += '  <td>' + board.writer +'</td>';
//    template += '  <td><button>상세</button></td>';
    template += '<tr/>';
    template += '<tr>';
    template += '  <td>' + board.content +'</td>';
    template += '<tr/>';

    return template;
}