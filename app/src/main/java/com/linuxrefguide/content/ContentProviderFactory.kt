package com.linuxrefguide.content

object ContentProviderFactory {
    fun getContentProvider(provider: String): ContentProvider {
        return when (provider) {
            "Linux" -> LinuxContentProvider
            "BurpSuite" -> BurpSuiteContentProvider
            "Nmap" -> NmapContentProvider
            "Wireshark" -> WiresharkContentProvider
            "Nessus" -> NessusContentProvider
            "Metasploit" -> MetasploitContentProvider
            "Python" -> PythonContentProvider
            "Bash" -> BashContentProvider
            "Java" -> JavaContentProvider
            "C++" -> CppContentProvider
            "JavaScript" -> JavaScriptContentProvider
            else -> throw IllegalStateException("Unknown content provider: $provider")
        }
    }
}