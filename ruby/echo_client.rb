require 'drb'

obj = DRbObject.new(nil, 'druby://localhost:9000')

print '-> '
while gets
    message = $_
    puts '<- ' + obj.echo(message)
    print '-> '
end
