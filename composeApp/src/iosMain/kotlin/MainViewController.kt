import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.platform.AccessibilityDebugLogger
import androidx.compose.ui.platform.AccessibilitySyncOptions
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

@OptIn(ExperimentalComposeApi::class)
fun MainViewController(): UIViewController = ComposeUIViewController(
configure = {
    accessibilitySyncOptions = AccessibilitySyncOptions.Always(object: AccessibilityDebugLogger {
        override fun log(message: Any?) {
            if (message == null) {println()
            } else {
                println("[a11y]: $message")
            }
        }
    })
}
)
{ App() }