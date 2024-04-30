import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(SharePlugin)
public class SharePlugin: CAPPlugin {
    @objc func share(_ call: CAPPluginCall) {
        DispatchQueue.main.async {
            let text = call.getString("text") ?? ""
            let filename = call.getString("filename") ?? ""

            let fileURL = FileManager.default.urls(for: .cachesDirectory, in: .userDomainMask).first!.appendingPathComponent("\(filename)")
            
            do {
                try text.write(to: fileURL, atomically: true, encoding: .utf8)
                
                let activityViewController = UIActivityViewController(activityItems: [fileURL], applicationActivities: nil)
                
                if let windowScene = UIApplication.shared.connectedScenes.first as? UIWindowScene,
                let window = windowScene.windows.first {
                    window.rootViewController?.present(activityViewController, animated: true, completion: nil)
                }
            } catch {
                print("Error writing string to file: \(error)")
            }

        }
        call.resolve([
            "result": "success"
        ])
    }
}
