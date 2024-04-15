package template.extensions

import com.kotlindiscord.kord.extensions.components.components
import com.kotlindiscord.kord.extensions.components.publicButton
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.chatCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.utils.respond

class TestExtension : Extension() {
    override val name = "test"

    override suspend fun setup() {
        chatCommand {
            name = "categories"
            description = "Category list"

            check { failIf(event.message.author == null) }

            action {
                message.respond {
                    components {
                        publicButton {
                            label = "Show categories!!"

                            action {
                                respond {
                                    content = "Electronics \n Clothing \n Home \n Beauty"
                                }
                            }
                        }
                    }
                }
            }
        }

        publicSlashCommand {
            name = "categories"
            description = "A simple example command that sends a categories."

            action {
                respond {
                    components {
                        publicButton {
                            label = "categories!"

                            action {
                                respond {
                                    content = "You pushed the categories!"
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
