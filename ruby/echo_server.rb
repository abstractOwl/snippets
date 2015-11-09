require 'drb'

class EchoService
    def echo(message)
        puts "<- #{message}"
        puts "-> #{message}"
        return message
    end
end

DRb.start_service 'druby://localhost:9000', EchoService.new
DRb.thread.join
