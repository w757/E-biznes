import ch.qos.logback.core.joran.spi.ConsoleTarget
import ch.qos.logback.core.ConsoleAppender

def environment = System.getenv("ENVIRONMENT") ?: "production"

def defaultLevel = INFO
def defaultTarget = ConsoleTarget.SystemErr

if (environment == "dev") {
	defaultLevel = DEBUG
	defaultTarget = ConsoleTarget.SystemOut

	logger("io.ktor.util.random", ERROR)
}

appender("CONSOLE", ConsoleAppender) {
	encoder(PatternLayoutEncoder) {
		pattern = "%boldGreen(%d{yyyy-MM-dd}) %boldYellow(%d{HH:mm:ss}) %gray(|) %highlight(%5level) %gray(|) %boldMagenta(%40.40logger{40}) %gray(|) %msg%n"

		withJansi = true
	}

	target = defaultTarget
}

root(defaultLevel, ["CONSOLE"])
