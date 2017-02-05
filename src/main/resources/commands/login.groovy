package commands

import org.ksprojects.crash.Main

welcome = { ->
    def hostName;
    try {
        hostName = InetAddress.getLocalHost().getHostName();
    } catch (UnknownHostException ignore) {
        hostName = 'localhost';
    }
    String banner = Main.getResourceAsStream('/banner.txt').text
    return """
${banner}
Logged into $hostName @ ${new Date()}
"""
}

prompt = { ->
    return "> ";
}
