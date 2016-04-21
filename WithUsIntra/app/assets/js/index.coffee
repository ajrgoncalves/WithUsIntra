$ ->
  $.get "/users", (users) ->
    $.each users, (index, user) ->
      $('#users').append ("<li>" + user.id + " " + user.name + " " + user.lastName + "</li>") 
       
    